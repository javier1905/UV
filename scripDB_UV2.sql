USE [master]
GO
/****** Object:  Database [UV6]    Script Date: 5/11/2019 00:12:08 ******/
CREATE DATABASE [UV6]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'UV6', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\UV6.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'UV6_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.MSSQLSERVER\MSSQL\DATA\UV6_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [UV6] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [UV6].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [UV6] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [UV6] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [UV6] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [UV6] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [UV6] SET ARITHABORT OFF 
GO
ALTER DATABASE [UV6] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [UV6] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [UV6] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [UV6] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [UV6] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [UV6] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [UV6] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [UV6] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [UV6] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [UV6] SET  ENABLE_BROKER 
GO
ALTER DATABASE [UV6] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [UV6] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [UV6] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [UV6] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [UV6] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [UV6] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [UV6] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [UV6] SET RECOVERY FULL 
GO
ALTER DATABASE [UV6] SET  MULTI_USER 
GO
ALTER DATABASE [UV6] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [UV6] SET DB_CHAINING OFF 
GO
ALTER DATABASE [UV6] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [UV6] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [UV6] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'UV6', N'ON'
GO
ALTER DATABASE [UV6] SET QUERY_STORE = OFF
GO
USE [UV6]
GO
/****** Object:  UserDefinedFunction [dbo].[f_cantidadDescargas]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE function [dbo].[f_cantidadDescargas] (@id_materia int)
Returns int
as
begin
	declare @resultado int
	select @resultado=count(*) from  recurso r 	
	where r.id_materia=@id_materia and r.estado=1
	return isnull(@resultado,1)
end
GO
/****** Object:  Table [dbo].[alumno]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[alumno](
	[legajo] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[dni] [int] NOT NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_alumno] PRIMARY KEY CLUSTERED 
(
	[legajo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[descarga]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[descarga](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fecha] [datetime] NOT NULL,
	[nombre_alumno] [varchar](50) NULL,
	[apellido_alumno] [varchar](50) NULL,
	[id_recurso] [int] NOT NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_descarga] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[inscripcion]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[inscripcion](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_alumno] [int] NULL,
	[id_materia] [int] NOT NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_inscripcion] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[materia]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[materia](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_materia] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[materiaXprofesor]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[materiaXprofesor](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[id_materia] [int] NULL,
	[id_profesor] [int] NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_materiaXprofesor] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[profesor]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[profesor](
	[legajo] [int] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[apellido] [varchar](50) NOT NULL,
	[dni] [int] NOT NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_profesor] PRIMARY KEY CLUSTERED 
(
	[legajo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[recurso]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[recurso](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[titulo] [varchar](50) NOT NULL,
	[detalle] [varchar](50) NOT NULL,
	[formato] [varchar](50) NOT NULL,
	[archivo] [varchar](300) NULL,
	[pub_priv] [bit] NULL,
	[id_materia] [int] NOT NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_recurso] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tipoUsuario]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tipoUsuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[descripcion] [varchar](50) NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_tipoUsuario] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[usuario]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[usuario](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[usuario] [int] NULL,
	[pass] [int] NULL,
	[id_tipoUsuario] [int] NULL,
	[estado] [bit] NULL,
 CONSTRAINT [pk_usuario] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[alumno] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (3, N'javier', N'martin', 456789, 1)
INSERT [dbo].[alumno] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (4, N'MARTA', N'LOPEZ', 888888888, 1)
INSERT [dbo].[alumno] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (5, N'MARCELO', N'MARTINEZ', 5654, 1)
INSERT [dbo].[alumno] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (11, N'juju', N'8787', 4556, 1)
SET IDENTITY_INSERT [dbo].[descarga] ON 

INSERT [dbo].[descarga] ([id], [fecha], [nombre_alumno], [apellido_alumno], [id_recurso], [estado]) VALUES (1, CAST(N'2019-11-03T20:34:07.133' AS DateTime), NULL, NULL, 8, 1)
INSERT [dbo].[descarga] ([id], [fecha], [nombre_alumno], [apellido_alumno], [id_recurso], [estado]) VALUES (2, CAST(N'2019-11-03T20:34:42.213' AS DateTime), NULL, NULL, 7, 1)
INSERT [dbo].[descarga] ([id], [fecha], [nombre_alumno], [apellido_alumno], [id_recurso], [estado]) VALUES (3, CAST(N'2019-11-03T20:36:00.670' AS DateTime), NULL, NULL, 7, 1)
INSERT [dbo].[descarga] ([id], [fecha], [nombre_alumno], [apellido_alumno], [id_recurso], [estado]) VALUES (4, CAST(N'2019-11-04T23:21:06.023' AS DateTime), N'javier', N'martin', 10, 1)
INSERT [dbo].[descarga] ([id], [fecha], [nombre_alumno], [apellido_alumno], [id_recurso], [estado]) VALUES (5, CAST(N'2019-11-04T23:44:48.467' AS DateTime), N'javier', N'martin', 11, 1)
SET IDENTITY_INSERT [dbo].[descarga] OFF
SET IDENTITY_INSERT [dbo].[inscripcion] ON 

INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (3, 3, 4, 1)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (4, 4, 1, 1)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (5, 11, 2, 0)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (6, 4, 5, 1)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (7, 4, 5, 1)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (8, 11, 5, 0)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (9, 3, 4, 0)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (10, 5, 3, 1)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (11, 5, 1, 1)
INSERT [dbo].[inscripcion] ([id], [id_alumno], [id_materia], [estado]) VALUES (12, 3, 1, 1)
SET IDENTITY_INSERT [dbo].[inscripcion] OFF
SET IDENTITY_INSERT [dbo].[materia] ON 

INSERT [dbo].[materia] ([id], [nombre], [estado]) VALUES (1, N'MATEMATICAS', 1)
INSERT [dbo].[materia] ([id], [nombre], [estado]) VALUES (2, N'QUIMICA', 0)
INSERT [dbo].[materia] ([id], [nombre], [estado]) VALUES (3, N'ALGEBRA', 1)
INSERT [dbo].[materia] ([id], [nombre], [estado]) VALUES (4, N'LENGUA', 1)
INSERT [dbo].[materia] ([id], [nombre], [estado]) VALUES (5, N'LOGICA', 1)
SET IDENTITY_INSERT [dbo].[materia] OFF
INSERT [dbo].[profesor] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (1, N'ROBERTO', N'GOMEZ', 33809842, 1)
INSERT [dbo].[profesor] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (2, N'MIRCO', N'ORTEGA', 627888, 1)
INSERT [dbo].[profesor] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (6, N'MIRIAN', N'SANTORO', 432432, 1)
INSERT [dbo].[profesor] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (7, N'MIRINA', N'BELDES', 432423, 1)
INSERT [dbo].[profesor] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (8, N'MARMAR', N'ROLO', 8777777, 1)
INSERT [dbo].[profesor] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (9, N'MIMI', N'MOMO', 345435, 1)
INSERT [dbo].[profesor] ([legajo], [nombre], [apellido], [dni], [estado]) VALUES (10, N'MACRI', N'GATO', 5345, 1)
SET IDENTITY_INSERT [dbo].[recurso] ON 

INSERT [dbo].[recurso] ([id], [titulo], [detalle], [formato], [archivo], [pub_priv], [id_materia], [estado]) VALUES (7, N'USERSTORY.pdf', N'Teorico de san toro', N'pdf', N'ver url', 0, 5, 1)
INSERT [dbo].[recurso] ([id], [titulo], [detalle], [formato], [archivo], [pub_priv], [id_materia], [estado]) VALUES (8, N'CTS DOCT.xlsx', N'DETALLE COUTAS', N'EXCEL', N'ver url', 0, 1, 1)
INSERT [dbo].[recurso] ([id], [titulo], [detalle], [formato], [archivo], [pub_priv], [id_materia], [estado]) VALUES (9, N'2019_TUP_4C_MSI_TEO_U3_UML_PUD (2).pdf', N'TP integrador', N'PDF', N'ver url', 1, 5, 1)
INSERT [dbo].[recurso] ([id], [titulo], [detalle], [formato], [archivo], [pub_priv], [id_materia], [estado]) VALUES (10, N'BookingReceipt_PCWOTT.pdf', N'CERTIFICADO', N'PDF', N'ver url', 1, 1, 1)
INSERT [dbo].[recurso] ([id], [titulo], [detalle], [formato], [archivo], [pub_priv], [id_materia], [estado]) VALUES (11, N'EjemlpoFactibilidad.pdf', N'EJEMPLO FACTIBILIDAD', N'PDF', N'ver url', 1, 4, 1)
INSERT [dbo].[recurso] ([id], [titulo], [detalle], [formato], [archivo], [pub_priv], [id_materia], [estado]) VALUES (12, N'Unidad1.pdf', N'UNIDAD UNO DE LENGUAS', N'PDF', N'ver url', 1, 4, 1)
SET IDENTITY_INSERT [dbo].[recurso] OFF
SET IDENTITY_INSERT [dbo].[tipoUsuario] ON 

INSERT [dbo].[tipoUsuario] ([id], [descripcion], [estado]) VALUES (1, N'alumno', 1)
INSERT [dbo].[tipoUsuario] ([id], [descripcion], [estado]) VALUES (2, N'profesor', 1)
INSERT [dbo].[tipoUsuario] ([id], [descripcion], [estado]) VALUES (3, N'admin', 1)
SET IDENTITY_INSERT [dbo].[tipoUsuario] OFF
SET IDENTITY_INSERT [dbo].[usuario] ON 

INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (1, 1, 33809842, 2, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (2, 2, 627888, 2, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (3, 3, 456789, 1, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (4, 4, 36248473, 1, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (5, 5, 5435346, 1, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (6, 6, 432432, 2, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (7, 7, 432423, 2, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (8, 8, 543543, 2, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (9, 9, 345435, 2, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (10, 10, 5345, 2, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (11, 11, 4556, 1, 1)
INSERT [dbo].[usuario] ([id], [usuario], [pass], [id_tipoUsuario], [estado]) VALUES (12, 12, 1234, 3, 1)
SET IDENTITY_INSERT [dbo].[usuario] OFF
/****** Object:  Index [UQ__alumno__D87608A7A2DB677A]    Script Date: 5/11/2019 00:12:08 ******/
ALTER TABLE [dbo].[alumno] ADD UNIQUE NONCLUSTERED 
(
	[dni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [UQ__profesor__D87608A7E936DFC4]    Script Date: 5/11/2019 00:12:08 ******/
ALTER TABLE [dbo].[profesor] ADD UNIQUE NONCLUSTERED 
(
	[dni] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[descarga]  WITH CHECK ADD  CONSTRAINT [fk_descarga_recurso] FOREIGN KEY([id_recurso])
REFERENCES [dbo].[recurso] ([id])
GO
ALTER TABLE [dbo].[descarga] CHECK CONSTRAINT [fk_descarga_recurso]
GO
ALTER TABLE [dbo].[inscripcion]  WITH CHECK ADD  CONSTRAINT [fk_inscripcion_alumno] FOREIGN KEY([id_alumno])
REFERENCES [dbo].[alumno] ([legajo])
GO
ALTER TABLE [dbo].[inscripcion] CHECK CONSTRAINT [fk_inscripcion_alumno]
GO
ALTER TABLE [dbo].[inscripcion]  WITH CHECK ADD  CONSTRAINT [fk_inscripcion_materia] FOREIGN KEY([id_materia])
REFERENCES [dbo].[materia] ([id])
GO
ALTER TABLE [dbo].[inscripcion] CHECK CONSTRAINT [fk_inscripcion_materia]
GO
ALTER TABLE [dbo].[materiaXprofesor]  WITH CHECK ADD  CONSTRAINT [fk_materiaXprofesor_materia] FOREIGN KEY([id_materia])
REFERENCES [dbo].[materia] ([id])
GO
ALTER TABLE [dbo].[materiaXprofesor] CHECK CONSTRAINT [fk_materiaXprofesor_materia]
GO
ALTER TABLE [dbo].[materiaXprofesor]  WITH CHECK ADD  CONSTRAINT [fk_materiaXprofesor_profesor] FOREIGN KEY([id_profesor])
REFERENCES [dbo].[profesor] ([legajo])
GO
ALTER TABLE [dbo].[materiaXprofesor] CHECK CONSTRAINT [fk_materiaXprofesor_profesor]
GO
ALTER TABLE [dbo].[recurso]  WITH CHECK ADD  CONSTRAINT [fk_recurso_materia] FOREIGN KEY([id_materia])
REFERENCES [dbo].[materia] ([id])
GO
ALTER TABLE [dbo].[recurso] CHECK CONSTRAINT [fk_recurso_materia]
GO
ALTER TABLE [dbo].[usuario]  WITH CHECK ADD  CONSTRAINT [fk_usuario_materia] FOREIGN KEY([id_tipoUsuario])
REFERENCES [dbo].[tipoUsuario] ([id])
GO
ALTER TABLE [dbo].[usuario] CHECK CONSTRAINT [fk_usuario_materia]
GO
/****** Object:  StoredProcedure [dbo].[pa_insertaAdmin]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertaAdmin]
@pass int
as
declare @usuario int
set @usuario= (select top 1 max(id) from usuario)
insert into usuario values (isnull(@usuario+1,1),@pass,3,1)
GO
/****** Object:  StoredProcedure [dbo].[pa_insertaAlumno]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertaAlumno]
@nombre varchar(50),
@apellido varchar(50),
@dni int
as
insert into alumno (nombre,apellido,dni) values (@nombre,@apellido,@dni)
GO
/****** Object:  StoredProcedure [dbo].[pa_insertaInscripcion]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertaInscripcion]
@id_alumno int,
@id_materia int
as
insert into inscripcion(id_alumno,id_materia, estado) values (@id_alumno,@id_materia,1)
GO
/****** Object:  StoredProcedure [dbo].[pa_insertaProfesor]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertaProfesor]
@nombre varchar(50),
@apellido varchar(50),
@dni int
as
insert into profesor (nombre,apellido,dni) values (@nombre,@apellido,@dni)
GO
/****** Object:  StoredProcedure [dbo].[pa_insertarDescargaPrivada]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertarDescargaPrivada]
@id_recurso int,
@nombre_alumno varchar(50),
@apellido_alumno varchar(50)
as
insert into descarga
values
(getdate(),@nombre_alumno,@apellido_alumno,@id_recurso,1)
GO
/****** Object:  StoredProcedure [dbo].[pa_insertarDescargaPublica]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[pa_insertarDescargaPublica]
@id_recurso int
as
insert into descarga
values
(getdate(),null,null,@id_recurso,1)
GO
/****** Object:  StoredProcedure [dbo].[pa_porcenDescargaxMateria]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[pa_porcenDescargaxMateria]
@nombre_alumno varchar(50),
@apellido_alumno varchar (50)
as
select d.id, d.fecha, r.titulo, r.formato, m.id as idMateria, m.nombre as nomMateria,   round(cast(count(d.id) as float) / cast(dbo.f_cantidadDescargas(m.id) as float) * cast(100 as float),3) 
from descarga d
inner join recurso r on d.id_recurso=r.id
inner join materia m on r.id_materia=m.id
where d.nombre_alumno=@nombre_alumno and d.apellido_alumno=@apellido_alumno
group by d.id, d.fecha, r.titulo, r.formato, m.id , m.nombre
GO
/****** Object:  Trigger [dbo].[tg_insertaAlumno]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[tg_insertaAlumno]
on [dbo].[alumno]
instead of insert
as
declare @id_usuario int,
		@nombre varchar(50),
		@apellido varchar(50),
		@dni int
set @id_usuario=(select top 1 max(id) from usuario)
select @nombre=nombre, @apellido=apellido, @dni=dni from inserted
insert into alumno values (isnull(@id_usuario+1,1),@nombre,@apellido,@dni,1)
insert into usuario values (isnull(@id_usuario+1,1),@dni,1,1)
GO
ALTER TABLE [dbo].[alumno] ENABLE TRIGGER [tg_insertaAlumno]
GO
/****** Object:  Trigger [dbo].[tg_insertaDescarga]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[tg_insertaDescarga]
on [dbo].[descarga]
instead of insert
as
declare @nombre_alumno varchar(50), 
        @apellido_alumno varchar(50),
		@id_alumno int,
		@id_recurso int, @pub_priv bit, 
		@valida_alumno bit,
		@id_materia_del_recurso int

select @nombre_alumno=nombre_alumno, @apellido_alumno=apellido_alumno, @id_recurso=id_recurso from inserted
set @pub_priv=(select pub_priv from recurso where id=@id_recurso) -- asume 1 si es privado
set @id_materia_del_recurso=(select id_materia from recurso where id=@id_recurso)

if @pub_priv = 0 -- pregunta si el recurso es publico 
	begin
		insert into descarga values (getdate(),null,null,@id_recurso,1)	
	end
else -- pero si el recurso es privado
	begin
		if exists (select * from alumno a 
				   where a.nombre=@nombre_alumno and a.apellido=@apellido_alumno and estado=1)
			begin
				set @valida_alumno=1; -- si el nombre y apellido del alumno existe la vareable vale 1 sino 0
				set @id_alumno =(select a.legajo from alumno a 
				   where a.nombre=@nombre_alumno and a.apellido=@apellido_alumno and estado=1)
			end
		else
			begin
				set @valida_alumno=0;
			end
	if @valida_alumno = 1 -- pregunto si exite el alumno con ese nombre y apellido
		begin
			if exists (select * from  inscripcion where id_alumno=@id_alumno and estado=1) -- pregunto si ademas esta inscripto en la 
			--materia a la cual pertenexe el recurso a descargar
				begin
					insert into descarga values (getdate(),@nombre_alumno,@apellido_alumno,@id_recurso,1)
				end
			else -- el alumno exte pero no esta inscripto 
				begin
					select 'alumno no inscripto en la materia a la cual pertenece el recurso'
				end
		end	
	else -- pero si no exite el alumno con ese nombre y apellido 
		begin
			select 'el alumno no exite con el nombre y apellidos ingresado'
		end
		
	end
GO
ALTER TABLE [dbo].[descarga] ENABLE TRIGGER [tg_insertaDescarga]
GO
/****** Object:  Trigger [dbo].[tg_insertaProfesor]    Script Date: 5/11/2019 00:12:08 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create trigger [dbo].[tg_insertaProfesor]
on [dbo].[profesor]
instead of insert
as
declare @id_usuario int,
		@nombre varchar(50),
		@apellido varchar(50),
		@dni int
set @id_usuario=(select top 1 max(id) from usuario)
select @nombre=nombre, @apellido=apellido, @dni=dni from inserted
insert into profesor values (isnull(@id_usuario+1,1),@nombre,@apellido,@dni,1)
insert into usuario values (isnull(@id_usuario+1,1),@dni,2,1)
GO
ALTER TABLE [dbo].[profesor] ENABLE TRIGGER [tg_insertaProfesor]
GO
USE [master]
GO
ALTER DATABASE [UV6] SET  READ_WRITE 
GO
