import os
from time import sleep
import numpy as np
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.common.exceptions import ElementNotInteractableException
from bs4 import BeautifulSoup
import csv

###########################################
# 일회용품 줄여가게 kakao map menu & photo 크롤링
# ver 1.0
# 2023.02.04
# edited by Eunbi Park
###########################################


f = open('recycling.csv', 'r', encoding='cp949')
rdr = csv.reader(f)
next(rdr) # header 제외

search_list = [] # kakao map search list

for line in rdr:
    addr = line[4].split(" ")
    # 상호명 + 주소의 3번째 항목 (군, 읍, 로, 길)
    # example: 구름에 (GURME) 부산 영도구 흰여울길
    search_list.append(line[3] +" " + addr[0] + " " + addr[1] + " "+ addr[2])
f.close()


# termianl UTF-8 encoding : chcp 65001

##########################################################################
##################### variable related selenium ##########################
##########################################################################

options = webdriver.ChromeOptions()
options.add_argument('headless')
options.add_argument('lang=ko_KR')
chromedriver_path = "chromedriver"
driver = webdriver.Chrome(os.path.join(os.getcwd(), chromedriver_path), options=options)  # chromedriver 열기

final_result_menu = []
final_result_photo = []

def main():
    global driver, menu_wb

    driver.implicitly_wait(4)  # 렌더링 될때까지 기다린다 4초
    driver.get('https://map.kakao.com/')  # 주소 가져오기

    for i in range(len(search_list)):
        search(search_list[i])

    driver.quit()

    print(final_result_menu)
    print(final_result_photo)

    # 메뉴 csv 저장
    with open('menu.csv', 'w', newline='') as f:
        writer = csv.writer(f)
        for i in range(len(final_result_menu)):
            if final_result_menu[i] == []: # 메뉴 정보가 존재하지 않을 때
                writer.writerow([])
            else:
                writer.writerow(np.concatenate(final_result_menu[i]).tolist())

    # 대표사진 csv 저장
    with open('photo.csv', 'w', newline='') as f:
        for p in final_result_photo:
            writer = csv.writer(f)
            writer.writerow([p])

    print("finish")


def search(place):
    global driver

    search_area = driver.find_element_by_xpath('//*[@id="search.keyword.query"]')  # 검색 창
    search_area.send_keys(place)  # 검색어 입력
    driver.find_element_by_xpath('//*[@id="search.keyword.submit"]').send_keys(Keys.ENTER)  # Enter로 검색
    sleep(1)

    # 검색된 정보가 있는 경우에만 탐색
    html = driver.page_source

    soup = BeautifulSoup(html, 'html.parser')
    place_lists = soup.select('.placelist > .PlaceItem') # 검색된 장소 목록

    # 검색된 첫 페이지 장소 목록 크롤링하기
    crawling(place_lists)
    search_area.clear()

    # 우선 더보기 클릭해서 2페이지
    try:
        driver.find_element_by_xpath('//*[@id="info.search.place.more"]').send_keys(Keys.ENTER)
        sleep(1)

        # 2~ 5페이지 읽기
        for i in range(2, 6):
            # 페이지 넘기기
            xPath = '//*[@id="info.search.page.no' + str(i) + '"]'
            driver.find_element_by_xpath(xPath).send_keys(Keys.ENTER)
            sleep(1)

            html = driver.page_source
            soup = BeautifulSoup(html, 'html.parser')
            place_lists = soup.select('.placelist > .PlaceItem') # 장소 목록 list

            crawling(place_lists)

    except ElementNotInteractableException:
        print('not found')
    finally:
        search_area.clear()


def crawling(placeLists):
    for i, place in enumerate(placeLists):
        menuInfos = getMenuPhotoInfo(i, driver)
        final_result_menu.append(menuInfos)
        print(menuInfos)

def getMenuPhotoInfo(i, driver):
    # 상세페이지로 가서 메뉴찾기
    detail_page_xpath = '//*[@id="info.search.place.list"]/li[' + str(i + 1) + ']/div[5]/div[4]/a[1]'
    driver.find_element_by_xpath(detail_page_xpath).send_keys(Keys.ENTER)
    driver.switch_to.window(driver.window_handles[-1])  # 상세정보 탭으로 변환
    sleep(1)

    menuInfos = []
    html = driver.page_source
    soup = BeautifulSoup(html, 'html.parser')

    # 1. 대표사진 크롤링
    try:
        photo = soup.find('span', class_='bg_present')['style'].split('\'')[1]
        final_result_photo.append(photo)
        print(photo)
    except TypeError:
        final_result_photo.append('')
        print("")

    # 2. 메뉴 크롤링
    # 메뉴의 3가지 타입
    menuonlyType = soup.select('.cont_menu > .list_menu > .menuonly_type')
    nophotoType = soup.select('.cont_menu > .list_menu > .nophoto_type')
    photoType = soup.select('.cont_menu > .list_menu > .photo_type')

    if len(menuonlyType) != 0:
        for menu in menuonlyType:
            menuInfos.append(_getMenuInfo(menu))
    elif len(nophotoType) != 0:
        for menu in nophotoType:
            menuInfos.append(_getMenuInfo(menu))
    else:
        for menu in photoType:
            menuInfos.append(_getMenuInfo(menu))

    driver.close()
    driver.switch_to.window(driver.window_handles[0])  # 검색 탭으로 전환

    return menuInfos

def _getMenuInfo(menu):
    menuName = menu.select('.info_menu > .loss_word')[0].text
    menuPrices = menu.select('.info_menu > .price_menu')
    menuPrice = ''

    if len(menuPrices) != 0:
        menuPrice =  menuPrices[0].text.split(' ')[1]

    return [menuName, menuPrice]

if __name__ == "__main__":
    main()