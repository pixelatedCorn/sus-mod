name = input('block name: ')

with open(f'blocks/{name}.json', 'w') as f:
    print(f.write
    (
        f'''\
{{
  "type": "minecraft:block",
  "pools": [
    {{
      "rolls": 1,
      "entries": [
        {{
          "type": "minecraft:item",
          "name": "susmod:{name}"
        }}
      ],
      "conditions": [
        {{
          "condition": "minecraft:survives_explosion"
        }}
      ]
    }}
  ]
}}
        '''
))