import pymysql
import csv
conn = pymysql.connect(host='localhost', user='root', password='680135', db='rebit', charset='utf8')

cur = conn.cursor()
sql = 'insert into store (category1, category2, store_name, address, tel) values (%s, %s, %s, %s, %s);'
f = open('recycling.csv', 'r', encoding='cp949')
rd = csv.reader(f)
next(rd) # header 제외

for line in rd:
    cur.execute(sql, (line[1], line[2], line[3], line[4], line[5]))

conn.commit()
conn.close()
f.close()
