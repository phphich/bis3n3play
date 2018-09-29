# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table tbCurriculum (
  id                        varchar(255) not null,
  th_name                   varchar(255),
  eng_name                  varchar(255),
  level                     varchar(255),
  year                      integer,
  faculty_id                varchar(255),
  constraint pk_tbCurriculum primary key (id))
;

create table tbFaculty (
  id                        varchar(255) not null,
  name                      varchar(255),
  address                   varchar(255),
  constraint pk_tbFaculty primary key (id))
;

create table tbStudent (
  id                        varchar(255) not null,
  name                      varchar(255),
  major                     varchar(255),
  gpa                       double,
  constraint pk_tbStudent primary key (id))
;

alter table tbCurriculum add constraint fk_tbCurriculum_faculty_1 foreign key (faculty_id) references tbFaculty (id) on delete restrict on update restrict;
create index ix_tbCurriculum_faculty_1 on tbCurriculum (faculty_id);



# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table tbCurriculum;

drop table tbFaculty;

drop table tbStudent;

SET FOREIGN_KEY_CHECKS=1;

