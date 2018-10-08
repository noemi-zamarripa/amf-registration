create index IX_F59610D1 on EventMonitor_EventMonitor (field2);
create index IX_9B391499 on EventMonitor_EventMonitor (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_14FFED5B on EventMonitor_EventMonitor (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_F1581977 on EventMonitor_StoreEvents (uuid_[$COLUMN_LENGTH:75$], groupId);