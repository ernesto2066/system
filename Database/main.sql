/*
 Navicat Premium Data Transfer

 Source Server         : System
 Source Server Type    : SQLite
 Source Server Version : 3030001
 Source Schema         : main

 Target Server Type    : SQLite
 Target Server Version : 3030001
 File Encoding         : 65001

 Date: 14/11/2021 21:37:27
*/

PRAGMA foreign_keys = false;

-- ----------------------------
-- Table structure for _expenses_old_20211109
-- ----------------------------
DROP TABLE IF EXISTS "_expenses_old_20211109";
CREATE TABLE "_expenses_old_20211109" (
  "idExpenses" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "idEmployee" INTEGER NOT NULL,
  "dateExpenses" DATE NOT NULL,
  "totalExpenses" VARCHAR(150) NOT NULL
);

-- ----------------------------
-- Records of _expenses_old_20211109
-- ----------------------------

-- ----------------------------
-- Table structure for _expenses_old_20211109_1
-- ----------------------------
DROP TABLE IF EXISTS "_expenses_old_20211109_1";
CREATE TABLE "_expenses_old_20211109_1" (
  "idExpenses" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "idEmployee" INTEGER NOT NULL,
  "dateExpenses" DATE NOT NULL,
  "totalExpenses" VARCHAR(150) NOT NULL,
  CONSTRAINT "expenses_id_employee_foreign" FOREIGN KEY ("idEmployee") REFERENCES "employee" ("idEmployee") ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- ----------------------------
-- Records of _expenses_old_20211109_1
-- ----------------------------

-- ----------------------------
-- Table structure for _expenses_old_20211109_2
-- ----------------------------
DROP TABLE IF EXISTS "_expenses_old_20211109_2";
CREATE TABLE "_expenses_old_20211109_2" (
  "idExpenses" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "idEmployee" INTEGER NOT NULL,
  "dateExpenses" DATE NOT NULL,
  "totalExpenses" NUMERIC NOT NULL
);

-- ----------------------------
-- Records of _expenses_old_20211109_2
-- ----------------------------

-- ----------------------------
-- Table structure for employee
-- ----------------------------
DROP TABLE IF EXISTS "employee";
CREATE TABLE "employee" (
  "idEmployee" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "name" VARCHAR(150) NOT NULL
);

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO "employee" VALUES (1, 'Adam');
INSERT INTO "employee" VALUES (2, 'Bolton');
INSERT INTO "employee" VALUES (3, 'Chelsea');
INSERT INTO "employee" VALUES (4, 'Elsy');
INSERT INTO "employee" VALUES (5, 'Vicent');
INSERT INTO "employee" VALUES (6, 'Warden');

-- ----------------------------
-- Table structure for expenses
-- ----------------------------
DROP TABLE IF EXISTS "expenses";
CREATE TABLE "expenses" (
  "idExpenses" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
  "idEmployee" INTEGER NOT NULL,
  "dateExpenses" DATE NOT NULL,
  "totalExpenses" NUMERIC NOT NULL,
  CONSTRAINT "expenses_id_employee_foreign" FOREIGN KEY ("idEmployee") REFERENCES "employee" ("idEmployee") ON DELETE RESTRICT ON UPDATE RESTRICT
);

-- ----------------------------
-- Records of expenses
-- ----------------------------
INSERT INTO "expenses" VALUES (1, 1, '01/01/2021', 2000000);
INSERT INTO "expenses" VALUES (2, 1, '02/01/2021', 1000000);
INSERT INTO "expenses" VALUES (3, 2, '01/01/2021', 400000);
INSERT INTO "expenses" VALUES (4, 3, '02/01/2021', 900000);
INSERT INTO "expenses" VALUES (5, 2, '03/02/2021', 1100000);
INSERT INTO "expenses" VALUES (6, 6, '02/01/2021', 5100000);
INSERT INTO "expenses" VALUES (7, 4, '02/01/2021', 4000000);
INSERT INTO "expenses" VALUES (8, 5, '03/02/2021', 899999);
INSERT INTO "expenses" VALUES (9, 3, '02/01/2021', 59999);
INSERT INTO "expenses" VALUES (10, 1, '03/02/2021', 500000);
INSERT INTO "expenses" VALUES (11, 2, '02/01/2021', 500000);
INSERT INTO "expenses" VALUES (12, 6, '03/02/2021', 1100000);
INSERT INTO "expenses" VALUES (13, 3, '03/02/2021', 1100000);

-- ----------------------------
-- Table structure for sqlite_sequence
-- ----------------------------
DROP TABLE IF EXISTS "sqlite_sequence";
CREATE TABLE "sqlite_sequence" (
  "name",
  "seq"
);

-- ----------------------------
-- Records of sqlite_sequence
-- ----------------------------
INSERT INTO "sqlite_sequence" VALUES ('_expenses_old_20211109_1', 0);
INSERT INTO "sqlite_sequence" VALUES ('employee', 6);
INSERT INTO "sqlite_sequence" VALUES ('_expenses_old_20211109_2', NULL);
INSERT INTO "sqlite_sequence" VALUES ('expenses', 13);

-- ----------------------------
-- Auto increment value for _expenses_old_20211109_1
-- ----------------------------

-- ----------------------------
-- Auto increment value for _expenses_old_20211109_2
-- ----------------------------

-- ----------------------------
-- Auto increment value for employee
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 6 WHERE name = 'employee';

-- ----------------------------
-- Auto increment value for expenses
-- ----------------------------
UPDATE "sqlite_sequence" SET seq = 13 WHERE name = 'expenses';

PRAGMA foreign_keys = true;
