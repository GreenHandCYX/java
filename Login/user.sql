


drop table if exists kind;

drop table if exists manager;

drop table if exists shopping;

drop table if exists shoppingCart;

drop table if exists user;


create table kind
(
   kid                  int not null AUTO_INCREMENT,
   mname                varchar(30),
   kname                varchar(50) not null,
   primary key (kid)
);


create table manager
(
   mid                  int  not null,
   mname                varchar(30) not null,
   mpass                varchar(40) not null,
   email                varchar(50),
   primary key (mname)
);


create table shopping
(
   pid                  int unsigned  not null AUTO_INCREMENT,
   kid                  int,
   pname                varchar(50),
   pinfo                varchar(50),
   price                decimal(10,2),
   purl                 varchar(100),
   pTime                date,
   primary key (pid)
);


create table shoppingCart
(
   uid                  int unsigned  not null,
   pid                  int unsigned  not null,
   fdate                date,
   primary key (uid, pid)
);


create table user
(
   uid                  int unsigned  not null AUTO_INCREMENT,
   mname                varchar(30),
   username             varchar(40) not null,
   password             varchar(40),
   info                 varchar(100),
   email                varchar(100),
   sex                  varchar(10),
   picture              varchar(100),
   primary key (uid)
);

alter table kind add constraint FK_Reference_9 foreign key (mname)
      references manager (mname) on delete restrict on update restrict;

alter table shopping add constraint FK_Reference_7 foreign key (kid)
      references kind (kid) on delete restrict on update restrict;

alter table shoppingCart add constraint FK_Reference_5 foreign key (uid)
      references user (uid) on delete restrict on update restrict;

alter table shoppingCart add constraint FK_Reference_8 foreign key (pid)
      references shopping (pid) on delete restrict on update restrict;

alter table user add constraint FK_Reference_6 foreign key (mname)
      references manager (mname) on delete restrict on update restrict;

