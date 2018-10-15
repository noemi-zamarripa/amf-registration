create index IX_94BAC67C on SearchBox_Foo (field2);
create index IX_C482F084 on SearchBox_Foo (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_BC55C806 on SearchBox_Foo (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_9F477D79 on SearchBox_SearchBox (field2);
create index IX_CD28CF41 on SearchBox_SearchBox (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A96E3203 on SearchBox_SearchBox (uuid_[$COLUMN_LENGTH:75$], groupId);