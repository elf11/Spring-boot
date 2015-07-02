CREATE TABLE dashboard(
  id serial NOT NULL,
  name character varying NOT NULL,
  description character varying NOT NULL,
  createdOn character varying NOT NULL,
  lastUpdateOn character varying NOT NULL,
  CONSTRAINT pk_dashboard_id PRIMARY KEY (id)
);
CREATE TABLE widget(
  id serial NOT NULL,
  name character varying NOT NULL,
  description character varying NOT NULL,
  createdOn character varying NOT NULL,
  lastUpdateOn character varying NOT NULL,
  type character varying NOT NULL,
  source character varying NOT NULL,
  sourceDetail character varying NOT NULL,
  destination character varying NOT NULL,
  destinationDetail character varying NOT NULL,
  timePeriod numeric NOT NULL,
  chartType character varying NOT NULL,
  displays numeric NOT NULL,
  dashboard_id bigint NOT NULL,
  CONSTRAINT pk_widget_id PRIMARY KEY (id),
  CONSTRAINT fk_widget__dashboard FOREIGN KEY (dashboard_id)
      REFERENCES dashboard (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE report(
  id serial NOT NULL,
  name character varying NOT NULL,
  description character varying NOT NULL,
  createdOn character varying NOT NULL,
  lastUpdateOn character varying NOT NULL,
  widget_id bigint NOT NULL,
  CONSTRAINT pk_report_id PRIMARY KEY (id),
  CONSTRAINT fk_report__widget FOREIGN KEY (widget_id)
      REFERENCES widget (id) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE
);
CREATE TABLE settings(
  id serial NOT NULL,
  name character varying NOT NULL,
  description character varying NOT NULL,
  createdOn character varying NOT NULL,
  lastUpdateOn character varying NOT NULL,
  CONSTRAINT pk_settings_id PRIMARY KEY (id)
);
CREATE TABLE username(
  id serial NOT NULL,
  name character varying NOT NULL,
  password_user character varying NOT NULL,
  CONSTRAINT pk_username_id PRIMARY KEY (id)
);
