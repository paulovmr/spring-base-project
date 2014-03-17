insert into profile (createdat, updatedat, type) values ('2014-03-03', '2014-03-03', 'admin');
insert into profile (createdat, updatedat, type) values ('2014-03-03', '2014-03-03', 'employee');
insert into profile (createdat, updatedat, type) values ('2014-03-03', '2014-03-03', 'user');

insert into usertable (createdat, updatedat, active, username, password) values 
('2014-03-03', '2014-03-03', true, 'admin', '$2a$10$cnWWKpcjWBSRneSU7c6O7.8YJAyCpOa5YL.PJT7uUaSd0W20zsgJG'); -- Senha: 123
insert into usertable (createdat, updatedat, active, username, password) values 
('2014-03-03', '2014-03-03', true, 'employee', '$2a$10$cnWWKpcjWBSRneSU7c6O7.8YJAyCpOa5YL.PJT7uUaSd0W20zsgJG'); -- Senha: 123
insert into usertable (createdat, updatedat, active, username, password) values 
('2014-03-03', '2014-03-03', true, 'user', '$2a$10$cnWWKpcjWBSRneSU7c6O7.8YJAyCpOa5YL.PJT7uUaSd0W20zsgJG'); -- Senha: 123

insert into usertable_profile (usertable_id, profiles_id) values (1, 1);
insert into usertable_profile (usertable_id, profiles_id) values (2, 2);
insert into usertable_profile (usertable_id, profiles_id) values (3, 3);