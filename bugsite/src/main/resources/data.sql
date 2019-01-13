--insert data into STATUS_MASTER table
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('NEW','New');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('CLR','Clarify');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('TAD','Triaged');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('CFM','Confirmed');

--insert data into  IMPORTANCE_MASTER table
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('LOW','Low');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('MED','Medium');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('HGH','High');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('CRT','Critical');

--insert data into  BUG table
INSERT INTO BUG (title,description,status_code,importance_code) VALUES  ('Functionality','error displayed while save','NEW','LOW');
INSERT INTO BUG (title,description,status_code,importance_code) VALUES  ('Functionality','Status cannot have provided data','NEW','HGH');
INSERT INTO BUG (title,description,status_code,importance_code) VALUES  ('Functionality','bug number format is not correct','CLR','MED');

