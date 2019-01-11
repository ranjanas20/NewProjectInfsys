
--create STATUS_MASTER table and insert data
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('NEW','New');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('CLR','Clarify');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('TAD','Triaged');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('CFM','Confirmed');

--create IMPORTANCE_MASTER table and insert data
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('LOW','Low');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('MED','Medium');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('HGH','High');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('CRT','Critical');

--create BUG table and insert data
INSERT INTO BUG (bug_id,title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  (1,'Functionality','error displayed while save','NEW','LOW',null,null,null,null);
INSERT INTO BUG (bug_id,title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  (2,'Functionality','Status cannot have provided data','NEW','HGH',null,null,null,null);
INSERT INTO BUG (bug_id,title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  (3,'Functionality','bug number format is not correct','CLR','MED',null,null,null,null);
