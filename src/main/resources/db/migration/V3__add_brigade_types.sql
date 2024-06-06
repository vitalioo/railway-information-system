insert into brigade_type
values (1, 'Локомотивная'),
    (2, 'Техники-ремонтники')
on conflict (brigade_type_id) do nothing;
