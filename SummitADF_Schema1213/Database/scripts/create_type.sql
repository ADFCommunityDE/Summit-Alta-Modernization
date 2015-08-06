create type point_type as object ( x_coord number, y_coord number);
.
/
create table interesting_points(
  id number primary key,
  coordinates point_type,
  description varchar2(20)
);
insert into interesting_points values(1001,point_type(0,0),'The origin');
commit;