CREATE TABLE IF NOT EXISTS AAGROUP (
  RID BIGINT(20) NOT NULL AUTO_INCREMENT,
  DESCRIPTION VARCHAR(255) DEFAULT NULL,
  RNAME VARCHAR(255) DEFAULT NULL,
  CREATION_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  UPDATED_BY VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (RID)
);

CREATE TABLE IF NOT EXISTS AAROLE (
  RID BIGINT(20) NOT NULL AUTO_INCREMENT,
  DESCRIPTION VARCHAR(255) DEFAULT NULL,
  RNAME VARCHAR(255) DEFAULT NULL,
  CREATION_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  UPDATED_BY VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (RID)
);

CREATE TABLE IF NOT EXISTS AAPERM (
  --	RID BIGINT(20) NOT NULL AUTO_INCREMENT,
  GROUPID BIGINT(20) NOT NULL,
  ROLEID BIGINT(20) NOT NULL,
  CONSTRAINT FK_PERM_GROUPID FOREIGN KEY (GROUPID) REFERENCES AAGROUP (RID),
  CONSTRAINT FK_PERM_ROLEID FOREIGN KEY (ROLEID) REFERENCES AAROLE (RID),
  --	CONSTRAINT UNQ_USERID_ROLEID UNIQUE (GROUPID, ROLEID),
  --	PRIMARY KEY (RID)
  PRIMARY KEY (GROUPID, ROLEID)
);

CREATE TABLE IF NOT EXISTS AAUSER (
  RID BIGINT(20) NOT NULL AUTO_INCREMENT,
  FIRSTNAME VARCHAR(255) NOT NULL,
  LASTNAME VARCHAR(255) NOT NULL,
  PASSWORD VARCHAR(255) NOT NULL,
  LOGINNAME VARCHAR(255) NOT NULL,
  CREATION_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  UPDATED_BY VARCHAR(255) DEFAULT NULL,
  PRIMARY KEY (RID)
);

CREATE TABLE IF NOT EXISTS AAGROUPUSER (
  GROUPID BIGINT(20) NOT NULL,
  USERID BIGINT(20) NOT NULL,
  CREATION_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  UPDATED_BY VARCHAR(255) DEFAULT NULL,
  CONSTRAINT FK_GROUPUSER_GROUPID FOREIGN KEY (GROUPID) REFERENCES AAGROUP (RID),
  CONSTRAINT FK_GROUPUSER_USERID FOREIGN KEY (USERID) REFERENCES AAUSER (RID),
  PRIMARY KEY (GROUPID, USERID)
);

CREATE TABLE IF NOT EXISTS AAMENU (
	RID BIGINT(20) NOT NULL AUTO_INCREMENT,
	VIEW_ORDER INT NOT NULL,
	RNAME VARCHAR(255) NOT NULL,
	TARGET_PAGE VARCHAR(255) NOT NULL,
	MAIN_CLASS VARCHAR(255) NOT NULL,
	PARENT_MENU_ID BIGINT(20) NOT NULL,
	ACTIVE INT NOT NULL,
	ICON VARCHAR(255) NOT NULL,
	CREATION_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	CREATED_BY VARCHAR(255) DEFAULT NULL,
	UPDATED_BY VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY (RID)
);

CREATE TABLE IF NOT EXISTS AAGROUPMENU (
  GROUPID BIGINT(20) NOT NULL,
  MENUID BIGINT(20) NOT NULL,
  CREATION_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  UPDATE_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  CREATED_BY VARCHAR(255) DEFAULT NULL,
  UPDATED_BY VARCHAR(255) DEFAULT NULL,
  CONSTRAINT FK_GROUPMENU_GROUPID FOREIGN KEY (GROUPID) REFERENCES AAGROUP (RID),
  CONSTRAINT FK_GROUPMENU_MENUID FOREIGN KEY (MENUID) REFERENCES AAMENU (RID),
  PRIMARY KEY (GROUPID, MENUID)
);