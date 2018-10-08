create table EventMonitor_EventMonitor (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	field1 VARCHAR(75) null,
	field2 BOOLEAN,
	field3 INTEGER,
	field4 DATE null,
	field5 VARCHAR(75) null
);

create table EventMonitor_StoreEvents (
	uuid_ VARCHAR(75) null,
	fooId LONG not null primary key,
	groupId LONG,
	logged DATE null,
	userId LONG,
	userName VARCHAR(75) null,
	requestIp VARCHAR(75) null,
	eventType VARCHAR(75) null
);