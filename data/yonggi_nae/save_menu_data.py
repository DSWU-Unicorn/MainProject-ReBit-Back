import pymysql
import csv
conn = pymysql.connect(host='localhost', user='root', password='680135', db='rebit', charset='utf8')

cur = conn.cursor()
sql = 'insert into menu (menu_id, store_id, menu_list) values (%s, %s, %s);'
f = open('menu.csv', 'r', encoding='cp949')
rd = csv.reader(f)

cnt = -1
for line in rd:
    cnt += 1
    try:
        menu = ' '.join(line)
        cur.execute(sql, (cnt, cnt, menu))
    except:
        continue

conn.commit()
conn.close()
f.close()
