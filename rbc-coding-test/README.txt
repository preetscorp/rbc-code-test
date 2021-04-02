*****Spring Boot Project*****   
1. Swagger :
http://localhost:8082/rbc/api/v2/api-docs

UI: http://localhost:8082/rbc/api/swagger-ui.html#/

2. H2 Console : 
http://localhost:8082/rbc/api/h2-console


3 API'S :

1. Insert a new Stock using /stock/add api. [http://localhost:8082/rbc/api/stock/add]
2. Query based on a Ticker and get the list of response. [http://localhost:8082/rbc/api/stock/AA]
3. Upload Bulk data by giving the Xlsx file [dataone.xlsx] with data specified in the format given below : [http://localhost:8082/rbc/api/stock/uploadFile]
quarter,stock,date,open,high,low,close,volume,percent_change_price,percent_change_volume_over_last_wk,previous_weeks_volume,
next_weeks_open,next_weeks_close,percent_change_next_weeks_price,days_to_next_dividend,percent_return_next_dividend

*********************************************************************************************************************************************************************

## Problem Background
    As a programmer with a fascination for stock markets, you got excited about a new data set that you discovered
    that there is a collection of records from the [Dow Jones Index from 2011](http://archive.ics.uci.edu/ml/datasets/Dow+Jones+Index#) that caught your attention. 
    You decided you'd like to build an application server (Spring Boot or NodeJS) that would allow multiple users to perform the following operations concurrently:
        - upload a bulk data set
        - query for data by stock ticker (e.g. input: AA, would return 12 elements if the only data uploaded were the single data set above)
        - add a new record
 
## Requirements
    - Your solution source code should be publicly available to share via a github / gitlab / bitbucket link
    - Solution should be able to run locally (e.g. no dependencies on managed services), but you are encouraged to leverage open source
      technologies (e.g. Docker, spring boot, nodeJS, mongo, postgresql, etc) for your solution.
    - The solution does not need to be perfect. Focus on what you consider is part of a good, maintainable, software solution and prioritize accordingly. Feel free to add notes on areas you would include in future iterations and rationale on some of your design decisions (e.g. in a README file). 
## Final Thoughts
    Some aspects of this challenge have been left intentionally vague.  Have fun! Build a solution you would be proud to show off :)
