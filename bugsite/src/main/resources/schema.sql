CREATE TABLE STATUS_MASTER(
	CODE VARCHAR(5),
   	DESCRIPTION VARCHAR(50),
	PRIMARY KEY (CODE)
	);

CREATE TABLE IMPORTANCE_MASTER(
	CODE VARCHAR(5),
   	DESCRIPTION VARCHAR(50),
	PRIMARY KEY (CODE)
	);

CREATE TABLE BUG ( 
	BUG_ID BIGINT GENERATED ALWAYS AS IDENTITY NOT NULL, 
	TITLE VARCHAR(255), 
	DESCRIPTION VARCHAR(255), 
	IMPORTANCE_CODE VARCHAR(255), 
	STATUS_CODE VARCHAR(255), 
	CREATED_BY VARCHAR(255), 
	CREATED_ON TIMESTAMP, 
	UPDATED_BY VARCHAR(255), 
	UPDATED_ON TIMESTAMP, 
	PRIMARY KEY (BUG_ID) ,
	FOREIGN KEY (STATUS_CODE) REFERENCES STATUS_MASTER(CODE),
	FOREIGN KEY (IMPORTANCE_CODE) REFERENCES IMPORTANCE_MASTER(CODE)
	) ;