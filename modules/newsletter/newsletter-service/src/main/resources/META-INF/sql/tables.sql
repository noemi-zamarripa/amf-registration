create table Newsletter_Newsletter (
	uuid_ VARCHAR(75) null,
	newsletterId LONG not null primary key,
	articleId VARCHAR(75) null,
	issueNumber INTEGER,
	issueDate DATE null,
	order_ INTEGER,
	isArticle BOOLEAN,
	author VARCHAR(75) null,
	mostRecent BOOLEAN,
	stringDate VARCHAR(75) null,
	month VARCHAR(75) null,
	year INTEGER
);