name = input('block name: ')
texture = input('texture name: ')
with open(f'blockstates/{name}.json', 'w') as f:
    print(f.write
    (
        f'''\
{{
   "variants": {{
   "": {{"model": "susmod:block/{name}"}}
   }}
}}
        '''
    ))

with open(f'models/block/{name}.json', 'w') as f:
    print(f.write
    (
        f'''\
{{
   "parent":"block/cube_all",
   "textures": {{
       "all": "susmod:block/{texture}"
   }}
}}
        '''
    ))

with open(f'models/item/{name}.json', 'w') as f:
    print(f.write
    (
        f'''\
{{
   "parent":"susmod:block/{name}"
}}
        '''
    ))