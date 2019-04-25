insert into users (username, password, enabled)
values ('admin', '$2a$10$IZKHradE8tA0hwG4pEoFRumYoRGVuP6TRlj9bv2L356R10FpE857y', 1);
insert into users (username, password, enabled)
values ('user', '$2a$10$mk8uzdriy13lm4hqTaHml.T/LMJLTnUMlbbGWxhRixYSDvieQK89e', 1);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');
insert into authorities (username, authority) values ('admin', 'ROLE_USER');
insert into authorities (username, authority) values ('user', 'ROLE_USER');
