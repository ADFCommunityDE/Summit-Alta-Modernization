DROP USER c##summit_adf CASCADE;

CREATE USER c##summit_adf IDENTIFIED BY summit_adf DEFAULT TABLESPACE users 
                                  TEMPORARY TABLESPACE temp  
                                  QUOTA UNLIMITED ON users;

GRANT create session TO c##summit_adf ;
GRANT alter session TO c##summit_adf ;
GRANT create table TO c##summit_adf ;
GRANT create trigger TO c##summit_adf ;
GRANT create view TO c##summit_adf ;
GRANT create sequence TO c##summit_adf ;
GRANT create synonym TO c##summit_adf ;
GRANT create type TO c##summit_adf ;
GRANT create procedure TO c##summit_adf ;
