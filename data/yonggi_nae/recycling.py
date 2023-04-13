import requests
from bs4 import BeautifulSoup
import pandas as pd
import re

##############################
# 일회용품 줄여가게 크롤링
# ver 1.0
# 2023.01.21
# edited by Eunbi Park
##############################

def recycling_store(result):

    url = f'https://www.recycling-info.or.kr/act4r2/main'
    print(url)
    response = requests.get(url)

    if (response.status_code == 200):
        html = response.content
        soupPa = BeautifulSoup(html, 'html.parser')
        for i in range(355):

            tag_tbody = soupPa.select(f'#storeItem{i} > div > div.basic-info > div > p')
            category = tag_tbody[0].string
            store_name = tag_tbody[1].string
            address = tag_tbody[2].string
            tel = soupPa.select_one(f"#storeItem{i} > div > div.detail-info > dl > dd").string
            category = re.sub(r"\s", "", category).split("|")

            print("category1: ", category[0])
            if(len(category) == 2):
                print("category2: ", category[1])
                result.append([category[0]] + [category[1]] + [store_name] + [address] + [tel])
            else:
                result.append([category[0]] + [""] + [store_name] + [address] + [tel])
            print("store_name: ", store_name)
            print("address: ", address)
            print("tel: ", tel)
            print()
    return

def main():
    result = []

    print('recycling store crawling >>>>>>>>>>>>>>>>>>>>>>>>>>')
    recycling_store(result)  # [CODE 1] 호출
    pa_tbl = pd.DataFrame(result, columns=('category1', 'category2', 'store_name', 'address', 'tel'))
    pa_tbl.to_csv('recycling.csv', encoding='cp949', mode='w', index=True)

if __name__ == '__main__':
    main()