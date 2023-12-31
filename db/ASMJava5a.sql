USE [master]
GO
/****** Object:  Database [ASM_Java5]    Script Date: 6/24/2023 8:50:45 PM ******/
CREATE DATABASE [ASM_Java5]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'ASM_Java5', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ASM_Java5.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'ASM_Java5_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\ASM_Java5_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [ASM_Java5] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [ASM_Java5].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [ASM_Java5] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [ASM_Java5] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [ASM_Java5] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [ASM_Java5] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [ASM_Java5] SET ARITHABORT OFF 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [ASM_Java5] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [ASM_Java5] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [ASM_Java5] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [ASM_Java5] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [ASM_Java5] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [ASM_Java5] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [ASM_Java5] SET  ENABLE_BROKER 
GO
ALTER DATABASE [ASM_Java5] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [ASM_Java5] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [ASM_Java5] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [ASM_Java5] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [ASM_Java5] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [ASM_Java5] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [ASM_Java5] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [ASM_Java5] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [ASM_Java5] SET  MULTI_USER 
GO
ALTER DATABASE [ASM_Java5] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [ASM_Java5] SET DB_CHAINING OFF 
GO
ALTER DATABASE [ASM_Java5] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [ASM_Java5] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [ASM_Java5] SET DELAYED_DURABILITY = DISABLED 
GO

USE [ASM_Java5]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/24/2023 8:50:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Account](
	[username] [varchar](50) NOT NULL,
	[hoten] [nvarchar](50) NOT NULL,
	[password] [nvarchar](50) NOT NULL,
	[email] [nvarchar](50) NOT NULL,
	[admin] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Bill]    Script Date: 6/24/2023 8:50:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Bill](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[username] [nvarchar](20) NULL,
	[fullname] [nvarchar](20) NOT NULL,
	[address] [nvarchar](100) NOT NULL,
	[phonenumber] [int] NOT NULL,
	[email] [nvarchar](30) NOT NULL,
	[total] [int] NULL,
	[date] [date] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 6/24/2023 8:50:45 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[images] [nvarchar](50) NOT NULL,
	[price] [int] NOT NULL,
	[qty] [int] NULL,
	[name] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'a', N'abc', N'1', N'huynhhoan@gmail.com', 0)
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'chinh', N'cong chinh', N'1', N'chinhtcps22317@fpt.edu.vn', 0)
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'duan', N'Quốc Duẩn', N'1', N'duan@gmail.com', 0)
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'hoan', N'duc hoan', N'1', N'hoanhdps24485@fpt.edu.vn', 0)
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'Khang', N'Gia Khang', N'1', N'khangngucho@gmail.com', 1)
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'Phat', N'Huỳnh Tấn Phát', N'1', N'phathtps20638@fpt.edu.vn', 0)
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'phuc', N'phuc', N'1', N'phuc@gmail.com', 0)
INSERT [dbo].[Account] ([username], [hoten], [password], [email], [admin]) VALUES (N'V?ng', N'Thiên Vọng', N'1', N'vong@gmail.com', 0)
GO
SET IDENTITY_INSERT [dbo].[Bill] ON 

INSERT [dbo].[Bill] ([id], [username], [fullname], [address], [phonenumber], [email], [total], [date]) VALUES (1, NULL, N'khang', N'HCM', 123548967, N'khang@gmail.com', NULL, CAST(N'2023-06-12' AS Date))
INSERT [dbo].[Bill] ([id], [username], [fullname], [address], [phonenumber], [email], [total], [date]) VALUES (2, NULL, N'khang', N'HCM', 123548967, N'khang@gmail.com', NULL, CAST(N'2023-06-12' AS Date))
INSERT [dbo].[Bill] ([id], [username], [fullname], [address], [phonenumber], [email], [total], [date]) VALUES (3, NULL, N'khang', N'HCM', 123548967, N'khang@gmail.com', NULL, CAST(N'2023-06-12' AS Date))
INSERT [dbo].[Bill] ([id], [username], [fullname], [address], [phonenumber], [email], [total], [date]) VALUES (7, N'chinh', N'trần công chinh', N'HCM', 905158693, N'chinh.176.tran@gnail.com', 3700, CAST(N'2023-06-12' AS Date))
INSERT [dbo].[Bill] ([id], [username], [fullname], [address], [phonenumber], [email], [total], [date]) VALUES (8, N'chinh', N'Huynh Duc Hoan', N'HCM', 123548967, N'huynhhoan@gmail.com', 9000, CAST(N'2023-06-12' AS Date))
INSERT [dbo].[Bill] ([id], [username], [fullname], [address], [phonenumber], [email], [total], [date]) VALUES (10, N'chinh', N'Huynh Duc Hoan', N'HCM', 123548967, N'huynhhoan@gmail.com', 2400, CAST(N'2023-06-13' AS Date))
INSERT [dbo].[Bill] ([id], [username], [fullname], [address], [phonenumber], [email], [total], [date]) VALUES (11, N'chinh', N'trần công chinh', N'HCM', 905158693, N'chinh.176.tran@gnail.com', 3600, CAST(N'2023-06-23' AS Date))
SET IDENTITY_INSERT [dbo].[Bill] OFF
GO
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (1, N'product-1.jpg', 900, NULL, N'Crab Pool Security')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (2, N'product-2.jpg', 100, NULL, N'Crab Pool Security')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (3, N'product-3.jpg', 500, NULL, N'Crab Pool Security')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (4, N'product-3.jpg', 9000, NULL, N'Crab Pool Security')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (19, N'product-3.jpg', 9000, NULL, N'Crab Pool Security')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (20, N'product-4.jpg', 900, NULL, N'Crab Pool Security')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (21, N'product-5.jpg', 150, NULL, N'Crab Pool Security')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (22, N'about.jpg', 1, 1, N'khang')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (23, N'cart-1.jpg', 500, 1, N'rau sạch')
INSERT [dbo].[Product] ([id], [images], [price], [qty], [name]) VALUES (24, N'about.jpg', 1, 1, N'pizaa')
SET IDENTITY_INSERT [dbo].[Product] OFF
GO
USE [master]
GO
ALTER DATABASE [ASM_Java5] SET  READ_WRITE 
GO
