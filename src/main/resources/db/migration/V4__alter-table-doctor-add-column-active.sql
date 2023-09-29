alter table doctor add isActive boolean;

update doctor set isActive = true;

ALTER TABLE doctor MODIFY isActive BOOLEAN NOT NULL;
