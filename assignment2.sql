create database assignment2;

use assignment2;

create table candidate (
	candidateID int PRIMARY KEY,
    fullName varchar(30),
    birthDay date,
    phone varchar(10),
    email varchar(30),
    candidateTypeID varchar(20)
);

create table experience(
	candidateID int primary key,
    expInYear int,
	proSkill varchar(30),
    constraint fk_experience foreign key (candidateID) references candidate(candidateID)
);

create table fresher(
	candidateID int primary key,
	graduationDate date,
    graduationRank varchar(10),
    education varchar(20),
	constraint fk_fresher foreign key (candidateID) references candidate(candidateID)
);

create table intern(
	candidateID int primary key,
	ajors varchar(20),
    semester varchar(20),
    universityName varchar(30),
    constraint fk_intern foreign key (candidateID) references candidate(candidateID)
);


create table certificate (
	certificateID int primary key,
    certificateName varchar(30),
    certificateRank varchar(30),
    certificateDate date,
    candidateID int,
    constraint fk_candidate foreign key (candidateID) references candidate(candidateID)
);

