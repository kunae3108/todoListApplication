INSERT INTO TODO_LIST.mt_todo_status (status_code, status_name) VALUES('PEND', 'Pending');
INSERT INTO TODO_LIST.mt_todo_status (status_code, status_name) VALUES('PROC', 'Processing');
INSERT INTO TODO_LIST.mt_todo_status (status_code, status_name) VALUES('DONE', 'Done');
INSERT INTO TODO_LIST.mt_todo_status (status_code, status_name) VALUES('REJT', 'Reject');

INSERT INTO TODO_LIST.inf_todo_task (id, content, status_code, title) VALUES(1, 'task initial#1', 'PEND', 'Pending Task init#1');
INSERT INTO TODO_LIST.inf_todo_task (id, content, status_code, title) VALUES(2, 'task initial#2', 'PROC', 'Processing Task init#1');
INSERT INTO TODO_LIST.inf_todo_task (id, content, status_code, title) VALUES(3, 'task initial#3', 'DONE', 'Done Task init#1');
INSERT INTO TODO_LIST.inf_todo_task (id, content, status_code, title) VALUES(4, 'task initial#4', 'REJT', 'Reject Task init#1');
