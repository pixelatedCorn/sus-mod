name = input('item name: ')
texture = input('texture name: ')

with open(f'models/item/{name}.json', 'w') as f:
    print(f.write
    (
        f'''\
{{
    "parent": "item/generated",
    "textures": {{
        "layer0": "susmod:item/{texture}"
    }}
}}
        '''
    ))