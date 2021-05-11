use spring_db;

truncate posts;
insert into posts (body, title)
values ('Oldsmobile', 'Silhouette');
insert into posts (body, title)
values ('Land Rover', 'LR2');
insert into posts (body, title)
values ('Aston Martin', 'V8 Vantage');
insert into posts (body, title)
values ('Toyota', 'Celica');
insert into posts (body, title)
values ('Ford', 'Ranger');
insert into posts (body, title)
values ('Cadillac', 'SRX');

insert into post_details(id, is_awesome, history_of_post, topic_description)
values (6, 1, 'Sixth post on my Spring-Blog. Great day to start blogging on !',
        'Sixth post');

update posts
set post_details_id = 6
where id = 6;



