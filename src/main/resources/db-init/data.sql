INSERT INTO AAGROUP(RID, RNAME, DESCRIPTION) VALUES(1, 'SUPERADMIN', 'SUPER ADMIN USER');
INSERT INTO AAGROUP(RID, RNAME, DESCRIPTION) VALUES(2, 'ADMIN', 'ADMIN USER');
INSERT INTO AAGROUP(RID, RNAME, DESCRIPTION) VALUES(3, 'STANDARD', 'STANDARD USER');
INSERT INTO AAGROUP(RID, RNAME, DESCRIPTION) VALUES(4, 'GUEST', 'GUEST USER');

INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(10, 'ROLEMAN', 'ROLE MANAGEMENT');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(20, 'GROUPMAN', 'GROUP MANAGEMENT');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(30, 'PERMMAN', 'PERMISSION MANAGEMENT');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(40, 'USERMAN', 'USER MANAGEMENT');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(50, 'GROUPUSERMAN', 'GROUP-USER MANAGEMENT');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(60, 'MENUMAN', 'MENU MANAGEMENT');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(70, 'GROUPMENUMAN', 'GROUP-MENU MANAGEMENT');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(100, 'COINSENDER', 'SEND COIN');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(110, 'COINRECEIVER', 'GET COIN');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(120, 'TOKENSENDER', 'SEND TOKEN');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(130, 'TOKENRECEIVER', 'GET TOKEN');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(140, 'BIDMAKER', 'BID TO BUY');
INSERT INTO AAROLE(RID, RNAME, DESCRIPTION) VALUES(150, 'ASKER', 'ASK FOR SALE');

INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 10);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 20);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 30);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 40);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 50);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 60);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 70);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 100);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 110);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 120);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 130);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 140);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(1, 150);

INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 40);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 50);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 100);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 110);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 120);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 130);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 140);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(2, 150);

INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(3, 100);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(3, 110);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(3, 120);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(3, 130);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(3, 140);
INSERT INTO AAPERM(GROUPID, ROLEID) VALUES(3, 150);

-- USER
-- non-encrypted password: jwtpass,	encrypted password: 821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a
INSERT INTO AAUSER(RID, FIRSTNAME, LASTNAME, PASSWORD, LOGINNAME) VALUES(1, 'superadmin', 'superadmin', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'superadmin');
INSERT INTO AAUSER(RID, FIRSTNAME, LASTNAME, PASSWORD, LOGINNAME) VALUES(2, 'admin', 'admin', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'admin');
INSERT INTO AAUSER(RID, FIRSTNAME, LASTNAME, PASSWORD, LOGINNAME) VALUES(3, 'standarduser', 'standarduser', '821f498d827d4edad2ed0960408a98edceb661d9f34287ceda2962417881231a', 'standarduser');

INSERT INTO AAGROUPUSER(GROUPID, USERID) VALUES(1, 1);
INSERT INTO AAGROUPUSER(GROUPID, USERID) VALUES(2, 2);
INSERT INTO AAGROUPUSER(GROUPID, USERID) VALUES(3, 3);

-- MENU

INSERT INTO AAMENU (RID, VIEW_ORDER, RNAME, TARGET_PAGE, MAIN_CLASS, PARENT_MENU_ID, ICON) VALUES('400',0,'Oba Portal','',NULL,400,'icon-food');
INSERT INTO AAMENU (RID, VIEW_ORDER, RNAME, TARGET_PAGE, MAIN_CLASS, PARENT_MENU_ID, ICON) VALUES('40001',1,'Roller','aarole',NULL,400,'icon-list-bullet');

INSERT INTO AAGROUPMENU(GROUPID, MENUID) VALUES(1, 400);
INSERT INTO AAGROUPMENU(GROUPID, MENUID) VALUES(1, 40001);
