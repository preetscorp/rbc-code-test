*****Spring Boot Project*****   
1. Swagger :
http://localhost:8082/rbc/api/v2/api-docs

UI: http://localhost:8082/rbc/api/swagger-ui.html#/

2. H2 Console : 
http://localhost:8082/rbc/api/h2-console


3 API'S :

1. Insert a new Stock using /stock/add api. 
2. Query based on a Ticker and get the list of response.
3. Upload Bulk data by giving the Xlsx file [dataone.xlsx] with data specified in the format given below : 
quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,
next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend

