-- Drop table if it exists
DROP TABLE IF EXISTS "widgets";

-- Drop sequence if it exists
DROP SEQUENCE IF EXISTS widgets_id_seq;

-- Create sequence
CREATE SEQUENCE widgets_id_seq 
    INCREMENT BY 1 
    MINVALUE 1 
    MAXVALUE 9223372036854775807 
    CACHE 1;

-- Create table
CREATE TABLE "widgets" (
    "id" bigint DEFAULT nextval('widgets_id_seq') NOT NULL,
    "name" text,
    "purpose" text,
    CONSTRAINT "widgets_okay" PRIMARY KEY ("id")
);
