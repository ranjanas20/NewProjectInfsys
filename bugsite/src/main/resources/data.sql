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
INSERT INTO BUG (bug_id,title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  (1,'Functionality','error displayed while save','NEW','LOW',null,null,null,null);
INSERT INTO BUG (bug_id,title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  (2,'Functionality','Status cannot have provided data','NEW','HGH',null,null,null,null);
INSERT INTO BUG (bug_id,title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  (3,'Functionality','bug number format is not correct','CLR','MED',null,null,null,null);

