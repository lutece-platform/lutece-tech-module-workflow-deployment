INSERT INTO workflow_workflow ( id_workflow, name, description, creation_date,is_enabled,workgroup_key ) VALUES 
(300,'Déploiement d\'un site','Déploiement d\'un site','2017-04-14 14:48:08',1,'all'),
(301,'Déploiement d\'un site non Lutece','Déploiement d\'un site non Lutece','2017-04-14 14:48:08',1,'all');

INSERT INTO workflow_state ( id_state,name,description,id_workflow,is_initial_state,is_required_workgroup_assigned,id_icon,display_order ) VALUES
(400,'Site non deployé','etat init',300,1,0,NULL,1),
(401,'Site déployé','etat final',300,0,0,NULL,2),
(402,'Site non déployé','etat init',301,1,0,NULL,2),
(403,'Site déployé','etat final',301,0,0,NULL,2);

INSERT INTO workflow_action ( id_action,name,description,id_workflow,id_state_before,id_state_after,id_icon,is_automatic,is_mass_action,display_order,is_automatic_reflexive_action ) VALUES
(500,'Deployer le site','Deployer le site',300,400,401,2,0,0,1,0),
(501,'Deployer le site non Lutece','Deployer le site non Lutece',301,402,403,2,0,0,1,0);

INSERT INTO workflow_task (id_task,task_type_key,id_action,display_order ) VALUES
(600,'taskCheckout',500,1),
(601,'taskAssemblySite',500,2),
(602,'taskDeploySite',500,3),
(603,'taskRunServerAction',500,4),
(604,'taskRunServerAction',500,5),
(605,'taskRunServerAction',500,6),
(606,'taskRunServerAction',500,7),

(650,'taskCheckout',501,1),
(651,'taskRunCustomMavenGoal',501,2),
(653,'taskRunServerAction',501,3),
(654,'taskRunServerAction',501,4),
(655,'taskRunServerAction',501,5),
(606,'taskRunServerAction',501,6);


