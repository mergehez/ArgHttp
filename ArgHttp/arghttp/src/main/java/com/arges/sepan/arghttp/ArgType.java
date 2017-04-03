package com.arges.sepan.arghttp;


/**
 * Created by arges on 4/3/2017.
 */

/**
 * Developers will choose these types for posting proper/correct data
 */
public enum ArgType {
    BOOLEAN,    // true or false

    BIT,        // alike BOOLEAN 1 or 0
    BYTE,       // between -+128
    TINYINT,    // between 0-255
    SMALLINT,   // between -+32,768
    SHORT,      // between -+32,768
    INTEGER,    // between -+- 2,147,483,648
    LONG,       // between -+-9,223,372,036,854,775,808
    BIGINT,     // same as LONG
    FLOAT,      // 32-bit floating BINARY point
    REAL,       // same as FLOAT
    DOUBLE,     // 64-bit floating BINARY point
    DECIMAL,    // 128-bit floating DECIMAL point
    NUMERIC,    // same as DECIMAL
    CHAR,       // single 16-bit Unicode character
    NCHAR,      // max length is 4000 characters
    NVARCHAR,   // same as NCHAR
    STRING,     // char array
    TEXT,       // same as string, max length is 2,147,483,647 bytes

    SMALLDATE,  // stores year, month, and day      from Jan 1, 1900 to Jun 6, 2079
    DATE,       // stores year, month, and day      from Jan 1, 1753 to Dec 31, 9999
    TIME,       // Stores hour, minute, and second
    TIMESTAMP,  // Stores year, month, day, hour, minute, and second

    XML,        // Stores XML data
    CURRENCY,   // Currency type for Access                     -+ -922,337,203,685,477.5808
    MONEY,      // Currency type for SQLServer and PostgreSQL   -+ -922,337,203,685,477.5808


    BINARY,     // max length is 4000 bytes
    VARBINARY,  // same as BINARY
    IMAGE,      // max length is 2,147,483,647 bytes




}
