# ExhangeRepo
Repo for Exchacge API

Создать сервис, который обращается к сервису курсов валют, и отдает gif в ответ:  

если курс по отношению к рублю за сегодня стал выше вчерашнего,  
то отдаем рандомную отсюда https://giphy.com/search/rich  
если ниже - отсюда https://giphy.com/search/broke  
Ссылки  
REST API курсов валют - https://docs.openexchangerates.org/  
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide  

Endpoints:
http://localhost:8080/gif для получения рандомной гиф
http://localhost:8080/sym для получения списка всех валют

Запуск .jar:  java -jar demo-0.0.1-SNAPSHOT-plain.jar
