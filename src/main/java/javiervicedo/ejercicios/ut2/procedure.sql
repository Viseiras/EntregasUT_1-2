CREATE OR REPLACE PROCEDURE public.borraDisco(n varchar)
    LANGUAGE plpgsql
AS $procedure$
BEGIN
    DELETE FROM Discos WHERE nombre = n;
END;
$procedure$
;