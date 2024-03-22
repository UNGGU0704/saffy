create database dbtest;

use dbtest;

-- 회원 정보 table 생성.
-- table name : ssafy_member
-- column
-- idx			int			auto_increments		PK
-- userid		varchar(16)	not null
-- username		varchar(20)
-- userpwd		varchar(16)
-- emailid		varchar(20)
-- emaildomain	varchar(50)
-- joindate		timestamp	default	current_timestamp
create table ssafy_member (
 idx			int			auto_increment,
 userid			varchar(16)	not null,
 username		varchar(20),
 userpwd		varchar(16),
 emailid		varchar(20),
 emaildomain	varchar(50),
 joindate		timestamp	default	current_timestamp,
 constraint member_idx_pk primary key (idx)
);

select now(), sysdate(), current_timestamp();


-- 회원 정보 등록
-- 'kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com' 등록시간
insert into ssafy_member (userid, username, userpwd, emailid, emaildomain)
values ('kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com');

insert into ssafy_member (userid, username, userpwd, emailid, emaildomain)
values ('홍길동', '9876', 'hongssafy', 'kimssafy', 'ssafy.com');

insert into ssafy_member (userid, username, userpwd, emailid, emaildomain, joindate)
values ('kimssafy', '김싸피', '1234', 'kimssafy', 'ssafy.com', now());

select *
from ssafy_member;



-- '김싸피', 'kimssafy', '1234'
insert into ssafy_member (username, userid, userpwd)
values ('안효인', 'troment', '0314');

select *
from ssafy_member;

-- '이싸피', 'leessafy', '1234'
-- '박싸피', 'parkssafy', '9876'
insert into ssafy_member (username, userid, userpwd)
values ('홍길동222', 'hong', '4567'),
		('강감찬', 'kang11111111111111111111111111', '9876');


-- userid가 troment 회원의 비번을 9876, 이메일 도메인을 ssafy.com으로 변경.
update ssafy_member
set userpwd = '9876', emaildomain = 'sssafy.com'
where userid = 'troment';

select * 
from ssafy_member;


-- userid가 troment 회원 탈퇴
delete from ssafy_member
where userid = 'troment';
