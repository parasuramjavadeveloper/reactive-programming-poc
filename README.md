# reactive-webflux
A Poc on reactive programming using spring webflux and Mongo DB

**Reactive Programming**:Asynchronous Data Streams
	Stream -Set of events ordered in time Ex:Time,Tweets
	
	In simple terms, reactive programming is about non-blocking applications that are asynchronous, event-driven, and require a small number of threads to serve the request. It is built around a publisher-subscriber pattern.

**Mongo Db Installation:**

Installation demo:https://youtu.be/FwMwO8pXfq0
(follow this video for installation)

Download Link:https://www.mongodb.com/try/download/community

1)Under available downloads ,click download 

2)double click on downloaded msi file ,Installation process is common.

3)It will be installed in "C:\Program Files" location

4)Add "C:\Program Files\MongoDB\Server\4.4\bin" this to environmental path variable.

5)To start mongo db server,go to command line and give the below command
->mongod

the above command will start mongodb server with default  port 27017

6)We can use command line or MongoDB compass to write queries.

command Line:to open mongo db command line,go to command line and give the following command
 ->mongo
 
 
**Basic Mongo Db Queries:**
     Show dbs  - to see all dbs
		 use dbname - create new db or switch to existing db
		Insert Data - db.books.insert({"name":"mongodb book"})
		Collections are like tables:
    show collections - used to see all collections
		Select Data : db.books.find()  (books is the table name)
		
    
 Backend:
 Dependencies:
	1)Spring Data Reactive MongoDB NOSQL
     Provides asynchronous stream processing with non-blocking back pressure for MongoDB.
   2)Spring Reactive Web WEB
       Build reactive web applications with Spring WebFlux and Netty.


