create table if not exists user (
  id   int(8) auto_increment primary key,
  name varchar(6),
  pwd  varchar(12)
)