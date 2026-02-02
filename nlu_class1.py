# simple_family_tree.py

# Family tree data
family_tree = {
    "Grandma": {
        "children": {
            "Father": {
                "children": {
                    "Me": {"children": {}},
                    "Brother1": {"children": {}},
                    "Brother2": {"children": {}},
                    "Brother3": {"children": {}}
                }
            }
        }
    }
}

# Print tree with indentation
def print_tree(tree, indent=0):
    for name, data in tree.items():
        print(" " * indent + name)
        print_tree(data["children"], indent + 4)

# Add a new member
def add_member(tree, parent_name, new_member):
    if parent_name in tree:
        tree[parent_name]["children"][new_member] = {"children": {}}
        return True
    for child in tree.values():
        if add_member(child["children"], parent_name, new_member):
            return True
    return False

# Find parent of a member
def find_parent(tree, member_name, parent=None):
    for name, data in tree.items():
        if name == member_name:
            return parent
        result = find_parent(data["children"], member_name, name)
        if result:
            return result
    return None

# Sample usage
if __name__ == "__main__":
    print("Family Tree:")
    print_tree(family_tree)

    print("\nParent of 'Me':", find_parent(family_tree, "Me"))

    print("\nAdding 'Baby' under 'Brother1':")
    add_member(family_tree, "Brother1", "Baby")
    print_tree(family_tree)
