DROP TABLE IF EXISTS task_run_server_action_cf;
CREATE TABLE task_run_server_action_cf(
  id_task INT DEFAULT NULL,
  action_key varchar(100) default NULL,
  PRIMARY KEY (id_task)
  );

