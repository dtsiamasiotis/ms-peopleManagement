create table patients(
    id bigint not null,
    first_name varchar(100),
    last_name varchar(100),
    primary key (id)
);

create sequence patients_id_seq;

create table personnel(
    id bigint not null,
    clinic_id bigint,
    occupation varchar(100),
    base_salary bigint,
    primary key (id)
);

create sequence personnel_id_seq;

create table workdays(
    id bigint not null,
    personnel_id bigint,
    start_time timestamptz,
    end_time timestamptz,
    primary key (id)
);

create sequence workdays_id_seq;

create table monthly_compensations(
    id bigint not null,
    personnel_id bigint,
    total_amount bigint,
    primary key (id)
);

create sequence monthlycompesations_id_seq;