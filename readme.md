
### Starting cassandra ###

./bin/cassandra

./bin/cqlsh

./bin/cqlsh localhost -u cassandra -p cassandra

 Default Setting <br/>
 Port : 9042 <br/>
 Username : cassandra <br/>
 Password : cassandra <br/> 



### Queries for the database ###

<b> create keyspace with following query </b> 

CREATE KEYSPACE test WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

CREATE TABLE test.users (
  id uuid PRIMARY KEY,
  username text,
  email text,
  password text
);

DROP TABLE test.users;