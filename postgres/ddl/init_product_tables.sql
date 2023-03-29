CREATE SCHEMA IF NOT EXISTS fitness;
CREATE TABLE IF NOT EXISTS fitness.product(
    id uuid NOT NULL,
    title character varying NOT NULL,
    weight smallint NOT NULL,
    calories smallint NOT NULL,
    proteins real NOT NULL,
    fats real NOT NULL,
    carbohydrates real NOT NULL,
    dt_create timestamp with time zone NOT NULL,
    dt_update timestamp with time zone NOT NULL,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT product_title_key UNIQUE (title)
);
CREATE TABLE IF NOT EXISTS fitness.ingredient
  (
      id uuid NOT NULL,
      product_id uuid NOT NULL,
      weight smallint NOT NULL,
      CONSTRAINT ingredient_pkey PRIMARY KEY (id),
      CONSTRAINT ingredients_product_uuid_fkey FOREIGN KEY (product_id)
          REFERENCES fitness.product(id)
  );
CREATE TABLE IF NOT EXISTS fitness.recipe(
    id uuid NOT NULL,
    title character varying NOT NULL,
    dt_create timestamp with time zone NOT NULL,
    dt_update timestamp with time zone NOT NULL,
    CONSTRAINT recipe_pkey PRIMARY KEY (id),
    CONSTRAINT recipes_title_key UNIQUE (title)
);
CREATE TABLE IF NOT EXISTS fitness.ingredient_recipe(
    recipe_id uuid NOT NULL,
    ingredient_id uuid NOT NULL,
    CONSTRAINT recipe_fkey FOREIGN KEY (recipe_id)
        REFERENCES fitness.recipe(id),
    CONSTRAINT ingredient_fkey FOREIGN KEY (ingredient_id)
        REFERENCES fitness.ingredient (id)
    );