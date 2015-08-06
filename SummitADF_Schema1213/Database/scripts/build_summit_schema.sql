

@@create_user

REM If this fails with ORA-01940 because c##summit_adf user is connected, issue the following as system:
REM select sid, serial#, username from v$session where username='C##SUMMIT_ADF';
REM alter system kill session '<SID>,<SERIAL#>' immediate;

REM Modify the next line to point to your database SID if not local (connect C##summit_adf/summit_adf@SID)

connect C##summit_adf/summit_adf
@@create_tables
@@create_sequences
@@create_functions
@@create_packages
@@data/S_REGION_Data
@@data/S_COUNTRIES_Data
@@data/S_DEPT_Data
@@data/S_TITLE_Data
@@data/S_EMP_Data
@@data/S_CREDIT_RATING_Data
@@data/S_CUSTOMER_Data
@@data/S_WAREHOUSE_Data
@@data/S_LONGTEXT_Data
@@data/S_IMAGE_Data
@@data/S_PRODUCT_CATEGORIES_Data
@@data/S_PRODUCT_Data
@@data/S_PAYMENT_TYPE_Data
@@data/S_PAYMENT_OPTIONS_Data
@@data/S_ORD_Data
@@data/S_ITEM_Data
@@data/S_INVENTORY_Data
@@create_triggers
@@create_type
commit;
