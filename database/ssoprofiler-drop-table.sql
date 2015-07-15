BEGIN

FOR c IN (SELECT table_name FROM user_tables

			where upper(table_name) like 'SSO_%'

) LOOP
EXECUTE IMMEDIATE ('DROP TABLE ' || c.table_name || ' CASCADE CONSTRAINTS');
END LOOP;

END;