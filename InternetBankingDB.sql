Use master

	IF EXISTS(SELECT name FROM master.dbo.sysdatabases
			  WHERE name = 'InternetBankingDB')
	BEGIN
		DROP DATABASE InternetBankingDB
		PRINT 'The database has been deleted'
	END

	CREATE DATABASE InternetBankingDB
	ON Primary
		(NAME = 'InternetBankingDB_Data',
		 FILENAME = 'C:\Logs_Data\InternetBankingDB_data.mdf',
		 SIZE = 5MB,
		 FILEGROWTH = 10%)

	LOG ON
		(NAME = 'InternetBankingDB_Log',
		 FILENAME = 'C:\Logs_Data\InternetBankingDB_Log.ldf',
		 SIZE = 5MB,
		 FILEGROWTH = 10%)
GO

USE InternetBankingDB
GO

CREATE TABLE users (
	id INT IDENTITY(1, 1) NOT NULL,
	name VARCHAR(50),
	surname VARCHAR(50),							
	email VARCHAR(50),	
	idNum VARCHAR(50),
	phoneNo VARCHAR(50),
	loginUsername VARCHAR(50),
	loginPassword VARCHAR(50),
	PRIMARY KEY(id), 	 						
) 
GO

PRINT 'The users table has been created'
GO

CREATE TABLE payment (
	id INT IDENTITY(1, 1) NOT NULL,
	accNo VARCHAR(50),
	receiverAccNo VARCHAR(50),	
	amount VARCHAR(50),
	paymentDate SMALLDATETIME DEFAULT GETDATE(),									
	userID INT NOT NULL,
	PRIMARY KEY(id), 
	FOREIGN KEY (userID) REFERENCES users(id),
) 
GO

PRINT 'The payment table has been created'
GO