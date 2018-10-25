create index IX_F42274A0 on Newsletter_Newsletter (articleId[$COLUMN_LENGTH:75$], isArticle);
create index IX_9AD5689C on Newsletter_Newsletter (issueDate, isArticle, mostRecent);
create index IX_8CC2DDE1 on Newsletter_Newsletter (issueNumber, isArticle, mostRecent);
create index IX_78F7060F on Newsletter_Newsletter (uuid_[$COLUMN_LENGTH:75$]);