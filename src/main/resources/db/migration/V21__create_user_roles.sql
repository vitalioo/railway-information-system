create table if not exists user_roles
(
    user_role_id serial primary key,
    user_id int not null,
    role_id int not null,
    foreign key (user_id) references users (id),
    foreign key (role_id) references roles (role_id)
)