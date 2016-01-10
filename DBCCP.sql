drop table if exist MOV;
drop table if exist CCN;

CREATE TABLE CCN (
    id integer NOT NULL,
    intestatario character varying(40) NOT NULL,
    dataapertura date NOT NULL,
    saldo decimal(15,2)  DEFAULT 0 NOT NULL
);

alter table CCN add primary key(id);



CREATE TABLE MOV (
    id integer NOT NULL,
    codintest integer NOT NULL references CCN(id),
    descr character varying(40) NOT NULL,
    coddest integer,
    importo decimal(15,2) NOT NULL,
    data date NOT NULL
);
alter table MOV add primary key(id);


insert into CCN values (1001,'Lorenzo De Carli','2015-11-06',0);
insert into CCN values (1002,'Paolo Tomelleri','2015-11-04',0);
insert into CCN values (1003,'Maurizio Benedetti','2015-10-30',0);
insert into CCN values (1004,'Nadia Dallago','2015-09-16',0);


update CCN set saldo=105.3 where id=1001;
update CCN set saldo=98 where id=1002;
update CCN set saldo=200 where id=1003;
update CCN set saldo=245 where id=1004;

insert into MOV values (101,1001,'prelievo contante',NULL,-15,'2015-11-07');
insert into MOV values (102,1001,'prelievo contante',NULL,-10,'2015-11-09');
insert into MOV values (103,1003,'versamento a Lorenzo',1001,-15,'2015-11-09');
insert into MOV values (104,1004,'versamento a Paolo',1002,-55,'2015-11-10');
