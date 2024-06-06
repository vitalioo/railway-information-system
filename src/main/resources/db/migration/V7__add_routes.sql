insert into route (route_type, initial_destination, final_destination, canceled)
values
    ('Внутренние', '3 hours', 'City A', 'City B', false),
    ('Международные', '1 hour', 'City C', 'City D', false),
    ('Туристические', '2.5 hours', 'City E', 'City F', false),
    ('Специальные маршруты', '30 hours', 'City A', 'City Z', true);

update route
set duration_seconds = 3000 where route_id=4;