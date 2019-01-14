--insert data into STATUS_MASTER table
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('NEW','New');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('CLR','Clarify');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('TAD','Triaged');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('CFM','Confirmed');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('CLS','Closed');
INSERT INTO STATUS_MASTER (CODE, DESCRIPTION) VALUES ('RVD','Resolved');

--insert data into  IMPORTANCE_MASTER table
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('LOW','Low');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('MED','Medium');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('HGH','High');
INSERT INTO IMPORTANCE_MASTER (CODE, DESCRIPTION) VALUES ('CRT','Critical');

--insert data into  BUG table
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','Status cannot have provided data','NEW','HGH',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','bug number format is not correct','CLR','MED',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','2-error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','3-Status cannot have provided data','NEW','HGH',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','4-bug number format is not correct','CLR','CRT',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','5-error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','6-Status cannot have provided data','NEW','HGH',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','7-bug number format is not correct','CLR','MED',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','8-error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','9-Status cannot have provided data','NEW','CRT',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','10-bug number format is not correct','CLR','MED',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','11-error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','12-Status cannot have provided data','NEW','HGH',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','13-bug number format is not correct','CLR','MED',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','13-error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','13-Status cannot have provided data','NEW','HGH',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','14-bug number format is not correct','CLR','MED',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','14-error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','14-Status cannot have provided data','NEW','HGH',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','15-bug number format is not correct','CLR','MED',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','16-error displayed while save','NEW','LOW',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','17-Status cannot have provided data','NEW','HGH',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');
INSERT INTO BUG (title,description,status_code,importance_code,created_on,created_by,updated_on,updated_by) VALUES  ('Functionality','18-bug number format is not correct','CLR','MED',CURRENT_DATE(),'admin',CURRENT_DATE(),'admin');

